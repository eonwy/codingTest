-- 코드를 작성해주세요
SELECT
    SUM(G.SCORE) AS SCORE,
    E.EMP_NO,
    E.EMP_NAME,
    E.POSITION,
    E.EMAIL
FROM
    HR_EMPLOYEES E
JOIN
    HR_GRADE G
ON
    E.EMP_NO = G.EMP_NO
WHERE
    E.POSITION = '팀원'
GROUP BY
    E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
ORDER BY
    SCORE DESC LIMIT 1;