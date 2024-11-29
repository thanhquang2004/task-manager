package com.example.task_manager.mapper;

import com.example.task_manager.dto.response.ColumnOrderResponse;
import com.example.task_manager.entity.ColumnOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnOrderMapper {
    List<ColumnOrderResponse> toListResponse(List<ColumnOrder> columnOrders);
}
