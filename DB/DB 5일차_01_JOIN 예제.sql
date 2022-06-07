use green2;

-- 각 학생들이 가야할 학부 사무실 위치를 조회
-- 지금처럼 속성 이름이 다른 경우, 테이블명과 .을 생략해도 됨
select 학생.*, 학부위치 from 학생
	join 학부
		on 학생.학부 = 학부.학부명
	order by 학생번호 asc;
    
use cookdb;

-- 구매 테이블과 사용자 테이블을 join하는 쿼리문을 작성
select * from usertbl
	join buytbl
		on usertbl.userID = buytbl.userID;
        
-- 강호동 회원이 구매한 제품 목록 조회
select usertbl.userID, userName, prodName from usertbl
	join buytbl
		on usertbl.userID = buytbl.userID
	where userName = '강호동';
-- 서브쿼리 이용
select userID, '강호동' as userName, prodName from buytbl
	where userID = (select userID from usertbl where userName = '강호동');
-- 운동화를 구매한 회원의 아이디를 조회
select distinct prodName, userID from buytbl where prodName = '운동화';
-- 운동화를 구매한 회원이 사는 지역들을 조회
select distinct prodName, addr from buytbl
	join usertbl
		on usertbl.userID = buytbl.userID
	where prodName = '운동화';

use 대학생2;
-- 각 대학생들의 지도교수님 이름을 조회
select 학번, 학생.이름, 교수.이름 as 지도교수 from 학생
	join 교수
		on 교수.교번 = 학생.교번;
        
-- 고길동 학생이 수강하는 강좌들 코드(강좌코드)를 조회
select 이름, 강좌코드 from 수강
	join 학생
		on 수강.학번 = 학생.학번
	where 학생.이름 = '고길동';

-- 고길동 학생이 수강하는 강좌들 이름(강좌명)을 조회
select 이름, 강좌명 from 수강
	join 강좌
		on 수강.강좌코드 = 강좌.강좌코드
	join 학생
		on 수강.학번 = 학생.학번
	where 이름 = '고길동';
    
select '고길동' as 이름, 강좌명 from 수강
	join 강좌
		on 수강.강좌코드 = 강좌.강좌코드
	where 학번 = (select 학번 from 학생 where 이름 = '고길동');
    
-- 나영석 교수가 강의하는 강좌코드를 조회
select 이름, 강좌코드 from 강좌
	join 교수
		on 강좌.교번 = 교수.교번
	where 이름 = '나영석';

-- 나영석 교수가 강의하는 강좌명을 조회
select 이름, 강좌명 from 강좌
	join 교수
		on 강좌.교번 = 교수.교번
	where 이름 = '나영석';
-- 나영석 교수가 강의하는 강의를 듣는 학번을 조회(중복 제거)
select distinct 이름, 학번 from 강좌
	join 교수 on 강좌.교번 = 교수.교번
    join 수강 on 수강.강좌코드 = 강좌.강좌코드
    where 이름 = '나영석';
    
-- 나영석 교수가 강의하는 강의를 듣는 학생이름을 조회
select distinct 교수.이름 as 교수이름, 학생.이름 as 학생이름 from 강좌
	join 교수 on 강좌.교번 = 교수.교번
    join 수강 on 수강.강좌코드 = 강좌.강좌코드
    join 학생 on 학생.학번 = 수강.학번
    where 교수.이름 = '나영석';
    
-- 컴퓨터개론을 수강하는 학생들의 수를 조회
select count(*) as `컴퓨터개론 수강생 수` from 수강
	join 강좌 on 수강.강좌코드 = 강좌.강좌코드
    where 강좌명 = '컴퓨터개론';

-- 컴퓨터개론을 수강하는 학생들 이름을 조회
select 강좌명, 학생.이름 from 학생
	join 수강 on 학생.학번 = 수강.학번
	join 강좌 on 수강.강좌코드 = 강좌.강좌코드
    where 강좌명 = '컴퓨터개론';
select 강좌명, 학생.이름 from 수강
	join 강좌 on 수강.강좌코드 = 강좌.강좌코드
    join 학생 on 학생.학번 = 수강.학번
    where 강좌명 = '컴퓨터개론';

-- 나영석 교수의 지도학생 이름을 조회
select 교수.이름 as 지도교수, 학생.이름 as 지도학생 from 학생
	join 교수 on 학생.교번 = 교수.교번
    where 교수.이름 = '나영석';

-- 두 테이블(테이블 A, 테이블 B)을 연결하는 경우 ON없이
-- 테이블 A의 행의 수가 n, 테이블 B의 행의 수가 m인 경우 n*m개의 행으로 된 결과가 나옴
-- 테이블 A의 한 개의 행과 테이블 B의 한 개의 행이 서로 합쳐진 전체 결과
select * from 학생 join 교수;

use green;
SELECT 직원.이름, 직원.직급, 직속상사.이름 as 직속상사 from 직원
	left join 직원 as 직속상사 on 직속상사.사번 = 직원.직속상사;