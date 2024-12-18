package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;


import java.sql.*;
import javax.sql.DataSource;
import java.util.List;
import java.util.ArrayList;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {

    //Added: declared data source for connection use
    private DataSource datasource;


    //Constructor
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    // Method to retrieve all categories:
    public List<Category> getAllCategories() {
        int id;
        String name, description;
        String query = """
                SELECT * FROM category;""";
        ArrayList<Category> findCategories = new ArrayList<>();
        try (Connection connection = datasource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("category_id");
                name = rs.getString("name");
                description = rs.getString("description");
                Category category = new Category(id, name, description);
                findCategories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findCategories;
    }

    @Override
    //Method to retrieve category by ID:
    public Category getById(int id) {
        String name, description;
        String query = """
                    SELECT * FROM  category
                    WHERE category_id = ?
                """;
        try (Connection connection = datasource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            name = rs.getString("name");
            description = rs.getString("description");
            Category category = new Category(id, name, description);
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    //Method to create a new category:
    public Category create(Category category) {
        String name = category.getName();
        String description = category.getDescription();

        try (Connection connection = datasource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("""
                    INSERT INTO categories(name, description)
                    VALUE(?, ?);
                    """, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                int rows = rs.getInt(1);
                return new Category(rows, name, description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } return null;
    }



        // Method to Update a category:
        @Override
        public void update (int categoryId, Category category) {
        String query = """
                UPDATE categories
                SET category_id = ?, name ?, description = ?
                WHERE category_id = ?""";

            try (Connection connection = datasource.getConnection()) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1,category.getCategoryId());
                stmt.setString(2, category.getName());
                stmt.setString(3, category.getDescription());
                stmt.setInt(4, category.getCategoryId());
                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public void delete ( int categoryId)
        {
            // delete category
        }

        private Category mapRow (ResultSet row) throws SQLException
        {
            int categoryId = row.getInt("category_id");
            String name = row.getString("name");
            String description = row.getString("description");

            Category category = new Category() {{
                setCategoryId(categoryId);
                setName(name);
                setDescription(description);
            }};

            return category;
        }

    }

