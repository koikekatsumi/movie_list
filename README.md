# 最終課題
このプロジェクトでは 映画に関するリストをSpring BootとMySQLを使ったCRUD処理を持つRESTfulなWebAPIを作成します
# 開発環境
- Java 17
- Spring Boot 3.3.1
- MySQL 8
# API の概要
## 名前を全件取得するAPI
- リクエスト
    - Method:GET
    - URL:/
- レスポンス
    - ステータスコード：200
    - ボディ：ユーザーのリストを Json 形式で返す
```curl

```
## クエリ文字列で指定した name のレコードを取得するAPI
- リクエスト
    - Method:GET
    - URL:/userNames?startsWith={name}
- レスポンス
    - ステータスコード：200
    - ボディ：ユーザーのリストを Json 形式で返す
```curl

```
## 指定した ID のレコードを取得するAPI
- リクエスト
    - Method:GET
    - URL:/userNames/{id}
- レスポンス
    - ステータスコード：200
    - ボディ：ユーザーのリストを Json 形式で返す
    - ID が存在しない場合はステータスコード 404 を返す
```curl

```
200 の場合のレスポンス
```json

```
404 の場合のレスポンス
```json

```

