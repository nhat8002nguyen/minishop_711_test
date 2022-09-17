package com.seveneleven.minishop.minishop.api.models.request.order;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ItemRequest {
	private final String productId;
	private final int quantity;
}
