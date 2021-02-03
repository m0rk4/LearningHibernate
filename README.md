# LearningHibernate
## Overview of Hibernate.

Hibernate – одной из реализаций спецификации Java Persistence API.

При работе с базой данных SQL в Java-приложении инструкции SQL передаются
в базу данных через прикладной интерфейс Java Database Connectivity (JDBC).
Независимо от того, как написан код SQL – вручную, включен в Java-код или
создан Java-кодом «на лету», для привязки аргументов к параметрам запроса,
выполнения запроса, итераций по результатам запроса, извлечения значений из
результирующей выборки и т. д. будет использован JDBC API. 

объектно-реляционное отображение – это автоматическое (и прозрачное) сохранение 
объекта из Java-приложения в таблицах базы данных SQL с использованием метаданных,
 описывающих отображение между классами приложения и схемой базы данных SQL. 
По сути, ORM работает за счет преобразования
(двустороннего) данных из одного представления в другое. 

Спецификация JPA определяет следующее:
* способ определения метаданных отображений – как хранимые классы и их
свойства соотносятся со схемой базы данных. JPA широко использует Java
аннотации в классах предметной модели, но вы можете определять отображения при помощи XML; 
* API для основных CRUD-операций, производимых над экземплярами хранимых классов;
наиболее известен класс javax.persistence.EntityManager,
используемый для сохранения и загрузки данных;
* язык и API для создания запросов, использующих классы и их свойства.
Этот язык называется Java Persistence Query Language (JPQL) и очень похож на SQL.
 Стандартизированный API позволяет программно создавать
запросы с критериями без работы со строковыми значениями;
* порядок взаимодействия механизма хранения с транзакционными сущностями для сравнения 
состояний объектов (dirty checking), извлечения ассоциаций и выполнения прочих оптимизаций. 
Кроме того, в последней спецификации JPA рассмотрены основные стратегии кэширования.

### I. Hello JPA