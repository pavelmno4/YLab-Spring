package com.edu.ulab.app.storage;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Storage<E, I> {
    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции

    E save(E entity);

    List<E> saveAll(Set<E> entities);

    Optional<E> findById(I id);

    List<E> findAllById(Set<I> ids);

    void delete(E entity);

    void deleteById(I id);
}
