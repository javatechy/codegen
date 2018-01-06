package javatechy.codegen.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javatechy.codegen.common.Constant;
import javatechy.codegen.dto.FreshDeskResponse;
import javatechy.codegen.dto.TicketDto;
import javatechy.codegen.service.FreshDeskIntegrationService;

@Service
public class FreshDeskIntegrationServiceImpl implements FreshDeskIntegrationService {

    private Logger logger = Logger.getLogger(FreshDeskIntegrationServiceImpl.class);

    private String FD_API_URL = "https://deepakfab.freshdesk.com/api/v2";
    private static String FD_AUTH_TOKEN = "HFDpPP3s7Ph1UFTtUp8L";

    private static PoolingHttpClientConnectionManager cm = null;
    private static CredentialsProvider provider = null;

    static {
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(1000);
        cm.setDefaultMaxPerRoute(20);
        provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(FD_AUTH_TOKEN, "X");
        provider.setCredentials(AuthScope.ANY, credentials);
    }

    private HttpClient httpClient = HttpClientBuilder.create()
        .setDefaultCredentialsProvider(provider)
        .setConnectionManager(cm)
        .build();

    @Override
    public FreshDeskResponse putRequest(TicketDto ticket, String uri, MultipartEntityBuilder multipartEntityBuilder) throws IOException, URISyntaxException {
        HttpPost post = new HttpPost(FD_API_URL + uri);
        post.setHeaders(makeHeaders(Constant.METHOD_PUT));
        post.setEntity(multipartEntityBuilder.build());
        HttpResponse response = httpClient.execute(post);
        return getResponseAndPrint(response);
    }

    @Override
    public FreshDeskResponse deleteRequest(String uri) throws IOException, URISyntaxException {
        HttpPost post = new HttpPost(FD_API_URL + uri);
        post.setHeaders(makeHeaders(Constant.METHOD_DELETE));
        HttpResponse response = httpClient.execute(post);
        return getResponseAndPrint(response);
    }

    @Override
    public FreshDeskResponse postRequest(TicketDto ticket, String uri, MultipartEntityBuilder multipartEntityBuilder) throws IOException, URISyntaxException {
        HttpPost post = new HttpPost(FD_API_URL + uri);
        post.setHeaders(makeHeaders(Constant.METHOD_POST));
        post.setEntity(multipartEntityBuilder.build());
        HttpResponse response = httpClient.execute(post);
        return getResponseAndPrint(response);
    }

    @Override
    public FreshDeskResponse getRequest(String uri) throws IOException, URISyntaxException {
        HttpGet get = new HttpGet(FD_API_URL + uri);
        get.setHeaders(makeHeaders(Constant.METHOD_GET));
        HttpResponse response = httpClient.execute(get);
        return getResponseAndPrint(response);
    }

    private Header[] makeHeaders(String requestMethod) {
        Header[] headerArray = null;
        List<Header> headersList = new ArrayList<>();
        headersList.add(new BasicHeader("Connection", "close"));
        // headersList.add(new BasicHeader("Content-type", "application/json; charset=utf-8"));
        String auth = FD_AUTH_TOKEN + ":X";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);
        headersList.add(new BasicHeader("Authorization", authHeader));
        if (requestMethod.equals(Constant.METHOD_PUT)) {
            headersList.add(new BasicHeader("Accept", "*/*"));
            headersList.add(new BasicHeader("Accept-Language", "en-US,en;q=0.8"));
        }
        headerArray = headersList.toArray(new Header[headersList.size()]);

        return headerArray;
    }

    private FreshDeskResponse getResponseAndPrint(HttpResponse response) throws IOException {
        int responseStatus = response.getStatusLine()
            .getStatusCode();
        String json = EntityUtils.toString(response.getEntity());
        FreshDeskResponse fdResponse = new FreshDeskResponse();
        logger.debug("Resposne Code from Freshdesk is " + responseStatus);
        logger.debug("Resposne recieved from Freshdesk is " + json);
        fdResponse.setHttpStatus(responseStatus);
        fdResponse.setResponseBody(json);
        return fdResponse;
    }

}
