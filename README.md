# Проект  "Вычислитель отличий".

### Hexlet tests and linter status:
[![Actions Status](https://github.com/ViktorSitnikov97/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ViktorSitnikov97/java-project-71/actions) [![example workflow](https://github.com/ViktorSitnikov97/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/ViktorSitnikov97/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/e9575cc8fa04dbb25e5f/maintainability)](https://codeclimate.com/github/ViktorSitnikov97/java-project-71/maintainability) [![Test Coverage](https://api.codeclimate.com/v1/badges/e9575cc8fa04dbb25e5f/test_coverage)](https://codeclimate.com/github/ViktorSitnikov97/java-project-71/test_coverage)

## Описание
Вычислитель отличий – программа, определяющая разницу между двумя структурами данных.

Возможности утилиты:
   * Поддержка разных входных форматов: yaml и json
   * Генерация отчета в виде plain text, stylish и json

Пример использования:
```
# формат plain
./build/install/app/bin/app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# формат stylish
./build/install/app/bin/app filepath1.json filepath2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}
```
## Требования
Иметь, либо установить:

> [Git installed](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
> 
> [Java](https://www.oracle.com/java/technologies/downloads/)
> 
> [Gradle](https://gradle.org/install/)

## Установка 
```
git clone git@github.com:ViktorSitnikov97/java-project-71.git
cd java-project-71
make install
```
## Запуск
```
./build/install/app/bin/app [-f required format(not necessary option)] filepeth1 filepeth2
```
## Демонстрация
Пример начала работы https://asciinema.org/a/645513
Пример сравнения двух файлов формата .json https://asciinema.org/a/645515
Пример сравнения двух файлов формата .yml https://asciinema.org/a/645516
Пример сравнения двух файлов формата .json, имеющих вложенные струкртуры https://asciinema.org/a/645517
Пример сравнения двух файлов формата .yml с выводом отчета типа plain https://asciinema.org/a/645520
Пример форматтера JSON, работающего с двумя файлами формата .json и .yml https://asciinema.org/a/645522




    
https://asciinema.org/a/643611

https://asciinema.org/a/644190

https://asciinema.org/a/644469

https://asciinema.org/a/644521

https://asciinema.org/a/644555

