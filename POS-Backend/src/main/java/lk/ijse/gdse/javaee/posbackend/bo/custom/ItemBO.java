package lk.ijse.gdse.javaee.posbackend.bo.custom;

import lk.ijse.gdse.javaee.posbackend.bo.SuperBO;
import lk.ijse.gdse.javaee.posbackend.dto.ItemDto;

import java.sql.Connection;
import java.util.List;

public interface ItemBO extends SuperBO {
    String saveItem(ItemDto item, Connection connection) throws Exception;

    ItemDto getItem(String itemCode, Connection connection) throws Exception;

    List<ItemDto> getAllItems(Connection connection) throws Exception;

    boolean updateItem(String itemCode, ItemDto item, Connection connection) throws Exception;

    boolean deleteItem(String itemCode, Connection connection) throws Exception;
}
