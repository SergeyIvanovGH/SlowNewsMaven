package ua.com.univerpulse.dao;

import ua.com.univerpulse.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class NewsDao extends AbstractJDBCDao<News, Integer> {
    @Override
    public String getSelectAllQuery() {
        return "SELECT id, title, date, image FROM public.news";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO public.user (title, date, image) \n" +
                "VALUES (?, ?, ?) returning id;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE public.user SET title= ?, date = ?, image = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM public.user WHERE id= ?;";
    }

    @Override
    public News create() throws PersistException {
        News g = new News();
        return persist(g);
    }

    public NewsDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<News> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<News> result = new LinkedList<>();
        try {
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setDate(rs.getString("date"));
                news.setImage(rs.getString("image"));

                result.add(news);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, News object) throws PersistException {
        try {
            statement.setString(1, object.getTitle());
            statement.setString(2, object.getDate());
            statement.setString(3, object.getImage());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, News object) throws PersistException {
        try {
            statement.setString(1, object.getTitle());
            statement.setString(2, object.getDate());
            statement.setString(3, object.getImage());
            statement.setInt(4, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

}
