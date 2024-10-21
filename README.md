# Task Manager Application

Đây là ứng dụng Task Manager được phát triển bằng Java. Dự án này tuân theo cấu trúc layered architecture để tổ chức code một cách rõ ràng và dễ bảo trì.

## Cấu trúc thư mục

```
.
├── controller/
├── dto/
│   └── request/
├── entity/
├── exception/
├── mapper/
├── repository/
├── service/
└── TaskManagerApplication.java
```

### Mô tả các thư mục

- `controller/`: Chứa các controller xử lý request từ client.
- `dto/`: Data Transfer Objects.
  - `request/`: DTO cho các request.
- `entity/`: Chứa các entity class đại diện cho các đối tượng trong database.
- `exception/`: Chứa các custom exception class.
- `mapper/`: Chứa các class để map giữa DTO và entity.
- `repository/`: Chứa các interface repository để tương tác với database.
- `service/`: Chứa business logic của ứng dụng.
- `TaskManagerApplication.java`: File chính để khởi động ứng dụng.

## Hướng dẫn cho Developers

1. **Controllers**: Tạo các REST endpoints trong thư mục `controller/`. Mỗi controller nên xử lý một nhóm chức năng liên quan.

2. **DTOs**: Định nghĩa các DTO trong thư mục `dto/`. Sử dụng thư mục con `request/` cho các DTO liên quan đến request.

3. **Entities**: Tạo các entity class trong thư mục `entity/`. Mỗi entity nên tương ứng với một bảng trong database.

4. **Exceptions**: Định nghĩa các custom exception trong thư mục `exception/` để xử lý các trường hợp lỗi cụ thể.

5. **Mappers**: Implement các mapper trong thư mục `mapper/` để chuyển đổi giữa DTO và entity.

6. **Repositories**: Tạo các repository interface trong thư mục `repository/` để định nghĩa các phương thức truy cập dữ liệu.

7. **Services**: Implement business logic trong các service class thuộc thư mục `service/`.

8. **Application**: Sử dụng `TaskManagerApplication.java` làm điểm khởi đầu của ứng dụng.

Hãy đảm bảo tuân thủ các nguyên tắc SOLID và clean code khi phát triển. Viết unit test cho các component quan trọng để đảm bảo tính ổn định của ứng dụng.

## Quy trình làm việc

1. Fork repository này.
2. Tạo branch mới cho mỗi feature hoặc bugfix.
3. Commit changes với message mô tả rõ ràng.
4. Tạo pull request để review code trước khi merge vào branch chính.

Nếu có bất kỳ câu hỏi hoặc đề xuất nào, vui lòng tạo issue trong repository.

Happy coding!