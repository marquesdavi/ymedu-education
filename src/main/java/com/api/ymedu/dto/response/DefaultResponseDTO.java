package com.api.ymedu.dto.response;

// Deve ser utilizada nos endpoints que precisarem de resposta de sucesso

public record DefaultResponseDTO(Boolean success, String message) {
}
