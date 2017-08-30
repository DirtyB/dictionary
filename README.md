Консольное клиент-серверное приложение, 
реализующее функцию словаря

### Сборка

Используется Maven 3. В корневой директроии проекта запустить

```
mvn package
```

### Запуск сервера

В директории `dictionary-server/target` запустить

```
java -jar dictionary-server-0.0.1-SNAPSHOT.jar 
```

По умолчанию API сервера доступно по адресу `http://localhost:8080`.
Чтобы изменить адрес и порт, которые будет слушать сервер, 
можно при вызове указать опции 
`-Dserver.address` и `-Dserver.port`.

### Запуск клиента

В директории `dictionary-client/target` запустить

```
java -jar dictionary-client-0.0.1-SNAPSHOT.jar localhost:8080 get hello 
```

Должно вывеститсь

```
привет
здравтвуйте
```

Если в Windows наблюдается проблема с кодировкой, запускать так:

```
java -Dfile.encoding=Cp866 -jar dictionary-client-0.0.1-SNAPSHOT.jar localhost:8080 get hello 
```

### Команды

`get <слово>` - возвращает значения слова.

`add <слово> <значение1> [<значение2> ...]` - добавляет в словарь указанные значения слова, сохраняя при это старые

`delete <слово> <значение1> [<значение2> ...]` - удаляет из словаря указанные значения слова

