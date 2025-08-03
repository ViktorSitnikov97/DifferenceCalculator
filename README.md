# Проект  "Вычислитель отличий"

### Hexlet tests and linter status:
[![Actions Status](https://github.com/ViktorSitnikov97/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ViktorSitnikov97/java-project-71/actions)
[![example workflow](https://github.com/ViktorSitnikov97/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/ViktorSitnikov97/java-project-71/actions)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=ViktorSitnikov97_DifferenceCalculator&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=ViktorSitnikov97_DifferenceCalculator)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ViktorSitnikov97_DifferenceCalculator&metric=coverage)](https://sonarcloud.io/summary/new_code?id=ViktorSitnikov97_DifferenceCalculator)

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
git clone git@github.com:ViktorSitnikov97/DifferenceCalculator.git
make install
```
## Запуск
```
./build/install/app/bin/app [-f required format(not necessary option)] filepeth1 filepeth2
```
## Демонстрация
> [Пример](https://asciinema.org/a/645513) начала работы
> 
> [Пример](https://asciinema.org/a/645515) сравнения двух файлов формата .json
> 
> [Пример](https://asciinema.org/a/645516) сравнения двух файлов формата .yml
> 
> [Пример](https://asciinema.org/a/645517) сравнения двух файлов формата .json, имеющих вложенные струкртуры
> 
> [Пример](https://asciinema.org/a/645520) сравнения двух файлов формата .yml с выводом отчета типа plain
> 
> [Пример](https://asciinema.org/a/645522) форматтера JSON, работающего с двумя файлами форматов .json и .yml
