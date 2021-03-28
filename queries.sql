## Part 1: Test it with SQL
CREATE TABLE job(
id INT PRIMARY KEY,
employer VARCHAR(100),
name VARCHAR(100),
skills VARCHAR(100));

SELECT *
FROM job;

## Part 2: Test it with SQL
SELECT name
FROM employer
WHERE location = ("St. Louis City");

## Part 3: Test it with SQL
DROP TABLE job;

## Part 4: Test it with SQL
SELECT name,description FROM skill
WHERE skill.id In (SELECT skills_id FROM job_skills
WHERE jobs_id In (SELECT id FROM job));
