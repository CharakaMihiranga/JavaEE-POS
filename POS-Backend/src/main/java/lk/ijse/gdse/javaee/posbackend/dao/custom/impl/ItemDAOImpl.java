package lk.ijse.gdse.javaee.posbackend.dao.custom.impl;

import lk.ijse.gdse.javaee.posbackend.dao.custom.ItemDAO;
import lk.ijse.gdse.javaee.posbackend.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    public static String SAVE_CUSTOMER = "INSERT INTO item VALUES(?, ?, ?, ?)";
    public static String GET_ITEM = "SELECT * FROM item WHERE code=?";
    public static String GET_ALL_ITEMS = "SELECT * FROM item";
    public static String UPDATE_ITEM = "UPDATE item SET name=?, qty=?, unitPrice=? WHERE code=?";
    public static String DELETE_ITEM = "DELETE FROM item WHERE code=?";
    @Override
    public String save(Item entity, Connection connection) throws Exception {
        try{
            var ps = connection.prepareStatement(SAVE_CUSTOMER);
            ps.setString(1, entity.getCode());
            ps.setString(2, entity.getName());
            ps.setInt(3, entity.getQty());
            ps.setDouble(4, entity.getUnitPrice());
            if (ps.executeUpdate() != 0 ){
                return "Item saved successfully!";
            }else {
                return "Failed to save the item!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean update(String id, Item entity, Connection connection) throws Exception {
       try{
        var ps = connection.prepareStatement(UPDATE_ITEM);
        ps.setString(1, entity.getName());
        ps.setInt(2, entity.getQty());
        ps.setDouble(3, entity.getUnitPrice());
        ps.setString(4, id);
        return ps.executeUpdate() != 0;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
    @Override
    public boolean delete(String id, Connection connection) throws Exception {
        try {
            var ps= connection.prepareStatement(DELETE_ITEM);
            ps.setString(1,id);
            return ps.executeUpdate() != 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Item get(String id, Connection connection) throws Exception {
        Item item = new Item();
        try{
            var ps = connection.prepareStatement(GET_ITEM);
            ps.setString(1,id);
            var rst = ps.executeQuery();
            while(rst.next()){
                item.setCode(rst.getString("code"));
                item.setName(rst.getString("name"));
                item.setQty(rst.getInt("qty"));
                item.setUnitPrice(rst.getDouble("unitPrice"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return item;
    }
    @Override
    public List<Item> getAll(Connection connection) throws Exception {
        List<Item> items = new ArrayList<>();
        try{
            var ps = connection.prepareStatement(GET_ALL_ITEMS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                items.add(new Item(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getInt("qty"),
                        rs.getDouble("unitPrice")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
