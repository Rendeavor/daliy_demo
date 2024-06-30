package com.jl.springbootdemo1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileDownloader {

    OkHttpClient client;

    public FileDownloader() {
        this.client = new OkHttpClient();
    }

    public void downloadFile(String fileUrl, String savePath) throws IOException {
        Request request = new Request.Builder()
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36")
                .addHeader("Referer", "strict-origin-when-cross-origin")
                .url(fileUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (!response.isSuccessful() || body == null) {
                throw new IOException("Failed to download file: " + response);
            }

            // 获取输入流
            InputStream inputStream = body.byteStream();

            // 创建输出流
            try (OutputStream outputStream = new FileOutputStream(savePath)) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            }
        }
    }

    public static void main(String[] args) {
        FileDownloader downloader = new FileDownloader();
        try {
            downloader.downloadFile("https://iyaofans.com/media/storage/focus/photo/45623", "D://image/file.jpg");
            System.out.println("File downloaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

