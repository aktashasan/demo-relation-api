
# demo-relation-app

İlişkisel veritabanı olan Postgresql ile çalışan CRUD işlemleri yapan 6 tablolu  bir API... 
Database işlemleri yapmak için sisteme kaydolup giriş yaptıktan sonra alınan token ile request'lere 
cevap vermektedir.

## Docker ile çalıştırma

Projeyi pullayın

```bash
  docker pull hasanaktas/demo-relation-app
```

Docker'da network oluşturun

```bash
  docker network create demo-app-spring-postgres
```

Postgresql'i Docker'da çalıştırın

```bash
  docker run -p 5432:5432  --name postgresdb --network demo-app-spring-postgres -e POSTGRES_PASSWORD=admin -d postgres
```

API'yi docker'da ayağa kaldırın

```bash
  docker run --network demo-app-spring-postgres --name demo-app -p 8080:8080 demo-relation-docker-app
```

Tarayıcıda endpointleri görebilmek için swagger linki

```http
  http://localhost:8080/swagger-ui/index.html#/
```

  
## API Kullanımı(Postman)

#### Kayıt Ol

```http
  POST http://localhost:8080/api/auth/signup
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Gerekli**. API anahtarınız. |
| `password` | `string` | **Gerekli**. API anahtarınız. |
| `email` | `string` | **Gerekli**. API anahtarınız. |
| `role` | `list` | **Gerekli**. API anahtarınız. |
| `address` | `list` | **Gerekli**. API anahtarınız. |

#### Örnek:
```JSON
  {
    "username": "user",
    "password": "123456789",
    "email": "user@domain.com",
    "role": ["mod","user"],
    "addressList":[
        {
        "city": "london"
    }
    ]
  }
```


#### Giriş Yap

```http
  POST  http://localhost:8080/api/auth/signin
```

| Parametre | Tip     | Açıklama                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Gerekli**. API anahtarınız. |
| `password` | `string` | **Gerekli**. API anahtarınız. |

#### Örnek:
```JSON
  {
    "username": "user",
    "password": "123456789"
  }
```

  
