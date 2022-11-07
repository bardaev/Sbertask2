# Sbertask2

## Задача 1

Приложение емеет 3 контроллера:
> /incorporate - запускает перевод сотрудников из компании 1 в компанию 2
> /company1 - возвращает текущее количество сотрудников в компании 1
> /company2 - возвращает текущее количество сотрудников в компании 2

## Задача 2

> SELECT h.id as id, h.name as name, SUM(s.score) AS total_score from hackers h join submissions s on s.hacker_id = h.id 
GROUP BY h.id 
HAVING SUM(s.score) > 0
order BY total_score DESC, h.name
