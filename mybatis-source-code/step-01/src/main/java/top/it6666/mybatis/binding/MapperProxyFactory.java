package top.it6666.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 代理类工厂
 * @author BNTang
 */
public class MapperProxyFactory<T> {
    private final Class<?> mapperInterface;

    public MapperProxyFactory(Class<?> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = (MapperProxy<T>) new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
