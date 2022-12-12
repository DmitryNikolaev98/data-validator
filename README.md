### Hexlet tests and linter status:
[![Actions Status](https://github.com/DmitryNikolaev98/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/DmitryNikolaev98/java-project-78/actions)
[![build](https://github.com/DmitryNikolaev98/java-project-lvl2/actions/workflows/main.yml/badge.svg)](https://github.com/DmitryNikolaev98/java-project-lvl2/actions/workflows/build-check.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/029dd99a737fbdbffb7d/maintainability)](https://codeclimate.com/github/DmitryNikolaev98/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/029dd99a737fbdbffb7d/test_coverage)](https://codeclimate.com/github/DmitryNikolaev98/java-project-78/test_coverage)

# Data validator

Data validator is a library that can be used to check the correctness of any data.

## Development

Before you can build this project, you must install and configure the following dependencies on your machine:

1. Java 17
2. Gradle

## Examples

### String validations

```bash
Validator v = new Validator();
StringSchema schema = v.string();

schema.isValid(""); // true
// Пока на вызван метод required(), null считается валидным
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid(5); // false
schema.isValid(""); // false

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// уже false, так как добавлена ещё одна проверка contains("whatthe")
```


## Create build

```bash
make build
```

## Testing

To launch your application's tests, run:

```bash
make report
```

## Clear config

```bash
make clear
```
