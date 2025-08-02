package io.github.greenstevester.yahueapi;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

final class HttpUtil {
  private HttpUtil() {
    // prevent instantiation
  }

  static String put(final URL baseUrl, final String path, final String body) {
    return getString(baseUrl, path, body, "PUT");
  }

  static String post(final URL baseUrl, final String path, final String body) {
    return getString(baseUrl, path, body, "POST");
  }

  private static String getString(final URL baseUrl, final String path, final String body, final String method) {
    try {
      var url = new URL(baseUrl.toString() + path);
      var connection = (HttpsURLConnection) url.openConnection();

      connection.setDoOutput(true);
      connection.setRequestMethod(method);
      connection.setRequestProperty("Host", connection.getURL().getHost());

      if (body != null) {
        try (var outputStream = connection.getOutputStream()) {
          try (var writer = new OutputStreamWriter(outputStream, UTF_8)) {
            writer.write(body);
            writer.flush();
          }
        }
      }
      connection.connect();
      try (var reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        return reader.lines().collect(Collectors.joining("\n"));
      }
    } catch (final IOException e) {
      throw new HueApiException(e);
    }
  }
}
