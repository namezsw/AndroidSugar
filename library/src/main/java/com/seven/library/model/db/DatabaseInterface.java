package com.seven.library.model.db;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 数据库操作接口
 * Created by Seven on 2017/2/15.
 */
public interface DatabaseInterface<Entity extends DBEntity, Key extends Serializable> {

    /**
     * closing available connections
     */
    void closeDBConnections();

    /**
     * 清理缓存
     */
    void clearDaoSession();

    /**
     * Delete all tables and content from our database
     */
    boolean dropDatabase(Class<? extends Serializable>... classes);

    boolean insert(Entity entity);

    boolean delete(Entity entity);

    boolean deleteByKey(Key key);

    boolean deleteList(List<Entity> entities);

    boolean deleteByKeyInTx(Key... keys);

    boolean deleteAll();

    boolean insertOrReplace(Entity entity);

    boolean update(Entity entity);

    boolean updateInTx(Entity... entities);

    boolean updateList(List<Entity> entities);

    Entity selectByPrimaryKey(Key key);

    List<Entity> loadAll();

    boolean refresh(Entity entity);

    /**
     * 事务
     *
     * @param runnable runnable
     */
    void runInTx(Runnable runnable);

    /**
     * 获取Dao
     *
     * @return dao
     */
    AbstractDao<Entity, Key> getAbstractDao();

    /**
     * 添加集合
     *
     * @param entities entities
     * @return 集合
     */
    boolean insertList(List<Entity> entities);

    /**
     * 添加集合
     *
     * @param entities entities
     * @return 集合
     */
    boolean insertOrReplaceList(List<Entity> entities);

    /**
     * 自定义查询器
     *
     * @return QueryBuilder
     */
    QueryBuilder<Entity> getQueryBuilder();

    List<Entity> queryRaw(String where, String... selectionArg);

    Query<Entity> queryRawCreate(String where, Object... selectionArg);

    Query<Entity> queryRawCreateListArg(String where, Collection<Object> selectionArg);
}
