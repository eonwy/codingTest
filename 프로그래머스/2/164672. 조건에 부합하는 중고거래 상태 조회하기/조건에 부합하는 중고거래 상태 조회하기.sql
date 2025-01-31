-- 코드를 입력하세요
SELECT
    U.BOARD_ID,
    U.WRITER_ID,
    U.TITLE,
    U.PRICE,
    CASE 
        WHEN U.STATUS = 'DONE' THEN '거래완료'
        WHEN U.STATUS = 'SALE' THEN '판매중'
        WHEN U.STATUS = 'RESERVED' THEN '예약중'
        ELSE U.STATUS
    END AS 'STATUS'
FROM
    USED_GOODS_BOARD U
WHERE
    U.CREATED_DATE = '2022-10-05'
ORDER BY
    U.BOARD_ID DESC;