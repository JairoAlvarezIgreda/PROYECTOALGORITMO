package com.udemy.backend.api.shared.domain.util;

/**
 * * Utilidades para convertir Strings.
 */
public final class CaseConverterUtils {
  private CaseConverterUtils() {
  }

  /**
   * * Convierte un String en CamelCase. (field_name a fieldName)
   *
   * @param field El field o el parámetro.
   * @return el String en CamelCase.
   */
  public static String toCamelCase(String field) {
    if (field == null)
      return null;

    String[] parts = field.split("_");
    StringBuilder camelCaseString = new StringBuilder(parts[0]);

    for (int i = 0; i < parts.length - 1; i++) {
      String part = parts[i + 1];
      camelCaseString.append(part.substring(0, 1).toUpperCase()).append(part.substring(1));
    }

    return camelCaseString.toString();
  }

  /**
   * * Convierte un String en SnakeCase. (fieldName a field_name)
   *
   * @param field El field o el parámetro.
   * @return el String en SnakeCase.
   */
  public static String toSnakeCase(String field) {
    if (field == null)
      return null;

    return field.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
  }
}
