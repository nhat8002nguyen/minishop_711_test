package com.seveneleven.minishop.minishop.api.models.request.order;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderRequest {
	private List<ItemRequest> items;
}
