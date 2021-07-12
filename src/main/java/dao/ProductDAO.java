package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO<Product> {
    private static final String SELECT_ALL_PRODUCT_QUERY = "SELECT * FROM product";
    private static final String INSERT_INTO_PRODUCT = "INSERT INTO product" + "(name,price,quantity,color,detail,category) VALUE" + "(?,?,?,?,?,?)";
    private static final String SELECT_PRODUCT_BY_ID_QUERY = "select * from product where id = ?";
    private static final String DELETE_QUERY = "DELETE FROM product WHERE `id` = ?";
    private static final String UPDATE_QUERY = "UPDATE product SET name=?, price=?, quantity=?, color=?, detail=?, category =? WHERE `id`=? ";






    private Connection connection;
    {
        try {
            connection = SQLConnection.getConnection();
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    PreparedStatement ps = null;
    ResultSet rs = null;

    public ProductDAO() {
    }


    @Override
    public List<Product> showALl() throws SQLException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        ps = connection.prepareStatement(SELECT_ALL_PRODUCT_QUERY);
        rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            String color = rs.getString("color");
            String detail = rs.getString("detail");
            String category = rs.getString("category");
            products.add(new Product(id, name, price, quantity, color, detail, category));
        }
        return products;
    }

    @Override
    public void insert(Product product) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = connection.prepareStatement(INSERT_INTO_PRODUCT);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.setString(4, product.getColor());
        ps.setString(5, product.getDetail());
        ps.setString(6, product.getCategory());
        ps.executeUpdate();
    }

    @Override
    public Product select(String id) throws SQLException, ClassNotFoundException {
        Product product = null;
        PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_BY_ID_QUERY);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String p_id = rs.getString("id");
            String p_name = rs.getString("name");
            String p_price = rs.getString("price");
            String p_quantity = rs.getString("quantity");
            String p_color = rs.getString("color");
            String p_detail = rs.getString("detail");
            String p_category = rs.getString("category");
            product =
                    new Product(Integer.parseInt(p_id),
                            p_name, Double.parseDouble(p_price),
                            Integer.parseInt(p_quantity), p_color,p_detail,p_category);
        }
        return product;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        boolean recordDelete;
        PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
        ps.setString(1, id);
        recordDelete = ps.executeUpdate() > 0;
        return recordDelete;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean updateRecord;
        PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getQuantity());
        ps.setString(4, product.getColor());
        ps.setString(5, product.getDetail());
        ps.setString(6, product.getCategory());
        ps.setInt(7, product.getId());
        ps.executeUpdate();
        updateRecord = ps.executeUpdate() > 0;
        return updateRecord;
    }
}
