select * from tbl_publisher;
show databases;
SELECT noOfCopies
FROM ( (tbl_book NATURAL JOIN tbl_book_copies ) NATURAL JOIN tbl_library_branch )
WHERE Title='The Lost Tribe' AND BranchName='Sharpstown' ;

SELECT BranchName, NoOfCopies
FROM ( (tbl_book NATURAL JOIN tbl_book_copies ) NATURAL JOIN tbl_library_branch )
WHERE Title='The Lost Tribe' ;

SELECT Name
FROM tbl_borrower B
WHERE NOT EXISTS
 (SELECT *FROM tbl_book_loans L WHERE B.CardNo = L.CardNo );

-- change 'today' to '2018-11-07 00:14:48' format
SELECT B.Title, R.Name, R.Address FROM tbl_book B, tbl_borrower R, tbl_book_loans BL, tbl_library_branch LB 
WHERE LB.BranchName='Sharpstown' AND LB.BranchId=BL.BranchId AND BL.DueDate='today' 
AND BL.CardNo=R.CardNo AND BL.BookId=B.BookId;

SELECT L.BranchName, COUNT(*)
FROM tbl_book_loans B, tbl_library_branch L
WHERE B.BranchId = L.BranchId
GROUP BY L.BranchName;

SELECT B.Name, B.Address, COUNT(*)
FROM tbl_borrower B, tbl_book_loans L
WHERE B.CardNo = L.CardNo
GROUP BY B.CardNo
HAVING COUNT(*) > 5 ;

SELECT
	BK.Title, 
	BC.NoOfCopies
	FROM tbl_book BK
	INNER JOIN tbl_book_copies BC ON BC.BookID = BK.BookID
	INNER JOIN tbl_library_branch LB ON LB.BranchID = BC.BranchID
	INNER JOIN tbl_author A ON A.authorId = BK.authId
WHERE AuthorName = 'Stephen King'
AND BranchName = 'Central';
