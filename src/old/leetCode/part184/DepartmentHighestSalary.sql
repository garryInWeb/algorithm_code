SELECT
  td.Name AS Department,
  te.Name AS Employee,
  Salary
FROM Employee te INNER JOIN Department td ON te.DepartmentId = td.Id
WHERE (DepartmentId, Salary) IN (SELECT
                                   DepartmentId,
                                   max(Salary)
                                 FROM Employee
                                 WHERE DepartmentId = te.DepartmentId)

SELECT
  td.Name AS Department,
  te.Name AS Employee,
  Salary
FROM (SELECT
        DepartmentId,
        max(Salary) AS maxSalary
      FROM Employee
      GROUP BY DepartmentId) T,
  Employee te INNER JOIN Department td
    ON te.DepartmentId = td.Id
WHERE Salary = maxSalary AND te.DepartmentId = T.DepartmentId


SELECT D.Name AS Department ,E.Name AS Employee ,E.Salary
from
  Employee E,
  Department D
WHERE E.DepartmentId = D.id
      AND (DepartmentId,Salary) in
          (SELECT DepartmentId,max(Salary) as max FROM Employee GROUP BY DepartmentId)