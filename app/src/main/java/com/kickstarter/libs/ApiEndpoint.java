package com.kickstarter.libs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kickstarter.libs.utils.Secrets;

public enum ApiEndpoint {
  PRODUCTION("Production", Secrets.Api.Endpoint.PRODUCTION),
  STAGING("Staging", Secrets.Api.Endpoint.STAGING),
  LOCAL("Local", "http://api.ksr.10.0.3.2.xip.io"),
  CUSTOM("Custom", null);

  private String name;
  private String url;

  ApiEndpoint(final @NonNull String name, final @Nullable String url) {
    this.name = name;
    this.url = url;
  }

  public @NonNull String url() {
    return url;
  }

  @Override public String toString() {
    return name;
  }

  public static ApiEndpoint from(final @NonNull String url) {
    for (final ApiEndpoint value : values()) {
      if (value.url != null && value.url.equals(url)) {
        return value;
      }
    }
    final ApiEndpoint endpoint = CUSTOM;
    endpoint.url = url;
    return endpoint;
  }
}
