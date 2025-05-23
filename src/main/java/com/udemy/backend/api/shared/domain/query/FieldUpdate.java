package com.udemy.backend.api.shared.domain.query;

import static com.udemy.backend.api.shared.domain.util.CaseConverterUtils.toCamelCase;

import lombok.Value;

@Value
/**
 * * Clase para actualizar un parámetro.
 */
public final class FieldUpdate {
  private final String field;
  private final Object value;

  /**
   * * Setear un field o parámetro.
   *
   * @param field El field.
   * @param value El valor a actualizar.
   * @return
   */
  public static FieldUpdate set(String field, Object value) {
    field = toCamelCase(field);

    return new FieldUpdate(field, value);
  }
}
