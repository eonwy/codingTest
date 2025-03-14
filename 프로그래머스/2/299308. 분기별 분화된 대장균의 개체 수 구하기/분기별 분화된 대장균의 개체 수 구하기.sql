-- 코드를 작성해주세요
SELECT
    CONCAT(CEIL((MONTH(DIFFERENTIATION_DATE)) / 3), 'Q') AS QUARTER,
    COUNT(*) AS ECOLI_COUNT
FROM 
    ECOLI_DATA
GROUP BY
    QUARTER
ORDER BY
    QUARTER;
    