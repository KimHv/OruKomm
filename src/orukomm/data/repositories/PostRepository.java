/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orukomm.data.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import orukomm.data.DataInitializer;
import orukomm.data.Database;
import static orukomm.data.Database.close;
import orukomm.data.entities.Post;

/**
 *
 * @author Ludvig
 */
public class PostRepository {
    private static Database db;

    public PostRepository() {

        db = Database.getInstance();

    }

    public Post getById(int id) {
        Post post = new Post();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = String.format("SELECT * FROM user WHERE id = '%d'", id); // måste ändras när tabellen är skapad.

        try {
            ps = db.getConnection().prepareStatement(query);
            rs = ps.executeQuery();

            if (Database.fetchedRows(rs) == 1) {
                // Username exists.
                post.setId(rs.getInt("id"));
                post.setTitel(rs.getString("titel"));
                post.setPoster(rs.getString("poster"));
                post.setDate(rs.getString("date"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(rs, ps, null);
        }

        return post;
    }

    public static ArrayList<Post> fillList() {
        ArrayList<Post> postList = new ArrayList<>();
        Post post = new Post();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = String.format("SELECT * FROM post ORDER BY date DESC");

        try {
            ps = db.getConnection().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setTitel(rs.getString("title"));
                post.setPoster(rs.getString("poster"));
                post.setDate(rs.getString("date"));
                
                postList.add(post);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            close(rs, ps, null);
        }
        return postList;

    }
}
