package com.ww.library.util;

import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.SSLSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

import static org.aspectj.bridge.MessageUtil.info;

public class HttpUtils {


    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_XML = "text/xml";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CHART_SET = "charset";
    // 每个post参数之间的分隔。随意设定，只要不会和其他的字符串重复即可。
    private static final String BOUNDARY = "-----SILVERBOX-boundary-7zD27LUSnh-----";


    /**
     * 将file转换为Bytes数组，再转换为String型
     * @param file file
     * @return bytesString
     */
    public static String StringToBytes(File file){
        FileInputStream fis = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String str="";
        StringBuilder sb = new StringBuilder("");
        try{
            // 建立文件上传流
            fis = new FileInputStream(file);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            out.write(buffer);
            out.flush();
            for (byte element: buffer ){
                sb.append(String.valueOf(element)+",");
            }
            sb.delete(sb.length()-1, sb.length());
            str=sb.toString();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("FileInputStream关闭失败");
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * 将file转换为Bytes数组，再转换为String型
     * @param file file
     * @return bytesString
     */
    public static String StringToBytes(MultipartFile file){
        String str="";
        StringBuilder sb = new StringBuilder("");
        try{
            byte[] buffer =file.getBytes();
            for (byte element: buffer ){
                sb.append(String.valueOf(element)+",");
            }
            sb.delete(sb.length()-1, sb.length());
            str=sb.toString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 发送GET请求
     * @param url 请求地址 带有参数直接拼接在URL后面
     * @return 返回JSON格式的字符串
     */
    private static String doGet(String url) {
        StringBuilder resultBuffer = new StringBuilder();
        try {
            URL localURL = new URL(url);
            URLConnection connection = localURL.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setConnectTimeout(6000000);
            httpURLConnection.setReadTimeout(6000000);
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader reader = null;
            String tempLine = null;
            try {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
                reader = new BufferedReader(inputStreamReader);
                while ((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("GET请求：" + url + "成功");
            }
        } catch (Exception e) {
            System.out.println("GET请求：" + url + "失败，出现异常");
            e.printStackTrace();
        }
        return resultBuffer.toString();
    }

    /**
     * 发送POST请求
     * @param url 请求地址 带有参数直接拼接在URL后面
     * @param outputStr 参数列表
     * @return 返回JSON格式的字符串
     */
    private static String doPost(String url, String outputStr) {
        StringBuilder resultBuffer = new StringBuilder();
        int responseCode;//响应码
        HttpURLConnection httpURLConnection;
        try {
            URL localURL = new URL(url);
            URLConnection connection = localURL.openConnection();
            httpURLConnection = (HttpURLConnection) connection;

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(outputStr.length()));
            httpURLConnection.setConnectTimeout(6000000);
            httpURLConnection.setReadTimeout(6000000);

            OutputStream outputStream = null;
            OutputStreamWriter outputStreamWriter = null;
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader reader = null;
            String tempLine = null;
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.flush();
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
                reader = new BufferedReader(inputStreamReader);
                while ((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                }
            } finally {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

                if (reader != null) {
                    reader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("POST请求：" + url + "成功");
            }
        } catch (Exception e) {
            System.out.println("POST请求：" + url + "失败,出现异常");
            e.printStackTrace();
        }
        return resultBuffer.toString();
    }
    /**
     * 发送POST请求
     *
     * @param url
     *            请求地址 带有参数直接拼接在URL后面
     * @param parameterMap
     *            参数列表
     * @return 返回JSON格式的字符串
     */
    public static String doPost(String url, Map<String, Object> parameterMap) {
        String resultBuffer = new String();
        StringBuffer parameterBuffer = new StringBuffer();
        if (parameterMap != null) {
            Iterator<String> iterator = parameterMap.keySet().iterator();
            String key = null;
            Object value = null;
            while (iterator.hasNext()) {
                key = (String) iterator.next();
                if (parameterMap.get(key) != null) {
                    value = parameterMap.get(key);
                } else {
                    value = "";
                }

                parameterBuffer.append(key).append("=").append(value);
                if (iterator.hasNext()) {
                    parameterBuffer.append("&");
                }
            }
        }
        resultBuffer = doPost(url, String.valueOf(parameterBuffer));
        return resultBuffer;
    }
}