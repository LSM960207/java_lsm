-- 홍길동 직원의 월급 내역서를 조회
select em_num as 사번, em_name as 이름, pa_salary as 월급, pa_date as 지급날짜 from pay
	join employee on pa_em_num = em_num
	where em_name = '홍길동';

-- 개발부 직원 명단을 조회
select * from employee where em_de_name = '개발부';

-- 월급 내역의 직급부분에 기입된 개발부 대신 직급이 들어가도록 수정
-- 4명의 직원을 각각 업데이트
update pay set pa_name = '차장' where pa_em_num = '2000001';
update pay set pa_name = '차장' where pa_em_num = '2000002';
update pay set pa_name = '대리' where pa_em_num = '2020001';
update pay set pa_name = '사원' where pa_em_num = '2022001';

update pay
	set pa_name = (select em_rn_name from employee where pa_em_num = em_num);

-- 회사 내의 모든 차장들의 사번과 이름을 조회
select em_num, em_name, em_rn_name from employee where em_rn_name = '차장';

-- 월급이 300 이상인 직원들의 이름을 조회
select distinct em_name, pa_salary from pay
	join employee on pa_em_num = em_num
    where pa_salary >= 300;

select pa_em_num, max(pa_salary) from pay
	join employee on em_num = pa_em_num
	group by pa_em_num
    having max(pa_salary) >= 300;
    
-- 직급별 인원수를 조회
select rn_name as 직급, count(em_num) as `인원 수` from `rank`
	left join employee on em_rn_name = rn_name
    group by rn_name;