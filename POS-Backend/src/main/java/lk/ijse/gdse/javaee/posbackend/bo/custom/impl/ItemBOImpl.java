package lk.ijse.gdse.javaee.posbackend.bo.custom.impl;

import lk.ijse.gdse.javaee.posbackend.bo.custom.ItemBO;
import lk.ijse.gdse.javaee.posbackend.dao.DAOFactory;
import lk.ijse.gdse.javaee.posbackend.dao.custom.ItemDAO;
import lk.ijse.gdse.javaee.posbackend.dto.ItemDto;
import lk.ijse.gdse.javaee.posbackend.entity.Item;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public String saveItem(ItemDto item, Connection connection) throws Exception {
        return itemDAO.save(new Item(
                item.getCode(),
                item.getName(),
                item.getQty(),
                item.getUnitPrice()
        ),connection);
    }

    @Override
    public ItemDto getItem(String itemCode, Connection connection) throws Exception {
        Item item = itemDAO.get(itemCode, connection);
        return new ItemDto(
                item.getCode(),
                item.getName(),
                item.getQty(),
                item.getUnitPrice()
        );
    }

    @Override
    public List<ItemDto> getAllItems(Connection connection) throws Exception {
        List<Item> items = itemDAO.getAll(connection);
        return items.stream()
                .map(item -> new ItemDto(
                        item.getCode(),
                        item.getName(),
                        item.getQty(),
                        item.getUnitPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateItem(String itemCode, ItemDto item, Connection connection) throws Exception {
        return itemDAO.update(itemCode, new Item(
                item.getCode(),
                item.getName(),
                item.getQty(),
                item.getUnitPrice()
        ),connection);
    }

    @Override
    public boolean deleteItem(String itemCode, Connection connection) throws Exception {
        return itemDAO.delete(itemCode,connection);
    }
}
