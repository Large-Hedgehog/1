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
    <li>(get) 로그인</li>
    <li>(patch) /pw 비밀번호 수정</li>
    <li>(patch) /pic 프로필 사진 수정</li>
    <li>(delete) 탈퇴</li>
</ul>

<h3>/board</h3>
<ul>
    <li>(get) ?page=1&row=40 마지막 page 값</li>
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