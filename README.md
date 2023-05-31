# 역할 분담
<ul>
    <li>
        1 - Controller, Service - 김다율
    </li>
    <li>
        2 - Mapper (interface, xml) - 서영기
    </li>
    <li>
        3 - 테스트 및 감독 - 황주은
    </li>
</ul>

# 기능 구현
<h3>/user</h3>
<ul>
    <li>(post) 회원가입</li>
    <li>(post) 로그인</li>
    <li>(patch) /pw 비밀번호 수정</li>
    <li>(patch) /pic 프로필 사진 수정</li>
    <li>(delete) 탈퇴</li>
</ul>

<h3>/board</h3>
<ul>
    <li>(get) /maxpage?row=40 마지막 page값</li>
    <li>(get) ?page=1&row=40 리스트</li>
    <li>(get) /{iboard} 디테일 (댓글5, 댓글 maxpag 값)</li>
    <li>-- 특정 페이지 글에 들어갈때 댓글 5개는 기본으로 보내고 , 댓글 최대 볼 수 있는 max값도 설정할것</li>
    <li>(post) 글등록</li>
    <li>(put) 글수정</li>
    <li>(delete) 글삭제</li>
</ul>

<h3>/board/cmt</h3>
<ul>
    <li>(post) 댓글 등록</li>
    <li>(get) /{iboard}?page=2 (갯수 5개씩)</li>
    <li>(put)  수정</li>
</ul>


# 주의사항
비밀번호 암호화 할때 , 무조건 백엔드에서 정규화해서 검사하고 디비로 보내야함
에러 코드 1,2,3 정해 놓고 적어두기. 그래야 계속 와서 -2가 뭐에요 이런 식으로 안물음..
제대로 넘어오면 숫자 1을 리턴하고, 오류나면 -1,-2 나오도록 오류 핸들링하기
길이는 맞는지, 암호화를 했더니 몇자 이하인지 .. 오류, 버그가 날때마다 문서화하기, 그때마다 추가함

# 로그인
GET 방식으로 하면 절대 안됨
무조건 POST 방식으로 BODY에 담아서 보내아함. 아니면 쿼리 스트링으로 비번 다보임
