package io.github.greenstevester.heuvana;

public final class HueApiException extends RuntimeException {
  public HueApiException(final Throwable cause) {
    super(cause);
  }

  public HueApiException(final String message) {
    super(message);
  }

  public HueApiException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
