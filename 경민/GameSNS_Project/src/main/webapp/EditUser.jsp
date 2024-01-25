<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <link rel="stylesheet" href="account_page.css">
</head>

<body>
    <form action="update.do" method="post">
        <div class="back">
            <div class="head_txt">회원정보 수정</div>
            <div>
                <!-- 아이디 -->
                <h1 class="txt_">아이디</h1>
                <input class="id_txtbox" type="text" id="username" name="id" value="<%= session.getAttribute("id") %>" readonly />

                <!-- 이름 -->
                <h1 class="txt1_" style="top: 80px">이름</h1>
                <input class="txtbox" type="text" id="name" name="name" value="<%= session.getAttribute("name") %>" readonly />

                <!-- 닉네임 -->
                <h1 class="txt1_" style="top: 160px">닉네임</h1>
                <input class="txtbox" type="text" id="nickname" name="nickname" value="<%= session.getAttribute("nickname") %>" required />

                <!-- 비밀번호 -->
                <h1 class="txt1_" style="top: 240px">비밀번호</h1>
                <input class="txtbox" type="password" id="pw" name="pw" value="<%= session.getAttribute("pw") %>" required />

                <!-- 전화번호 -->
                <h1 class="txt1_" style="top: 320px">전화번호</h1>
                <input class="txtbox" style="top: 350px" type="text" id="tel" name="tel" value="<%= session.getAttribute("tel") %>" required />

                <!-- 주소 -->
                <h1 class="txt1_" style="top: 400px">주소</h1>
                <input class="address_box" type="text" placeholder="주소" id="address_" name="address" value="<%= session.getAttribute("address") %>" required />
                <input class="search_box" type="button" onclick="address_search()" value="검색" />
                <input class="txtbox" style="top: 480px" type="text" placeholder="상세주소" id="detailAddress"
                    name="detail_address" value="<%= session.getAttribute("detailAddress") %>" />

                <!-- 이메일 -->
                <h1 class="txt1_" style="top: 530px">이메일</h1>
                <input class="emailbox1" type="text" placeholder="이메일" name="frontM" value="<%= session.getAttribute("frontM") %>" />
                <select class="emailbox3" name="LastM">
                    <option value="@naver.com" <%= (session.getAttribute("LastM") != null && session.getAttribute("LastM").equals("@naver.com")) ? "selected" : "" %>>@naver.com</option>
					<option value="@daum.net" <%= (session.getAttribute("LastM") != null && session.getAttribute("LastM").equals("@daum.net")) ? "selected" : "" %>>@daum.net</option>
					<option value="@gmail.com" <%= (session.getAttribute("LastM") != null && session.getAttribute("LastM").equals("@gmail.com")) ? "selected" : "" %>>@gmail.com</option>
                </select>

                <!-- 가입 버튼 및 취소 버튼 -->
                <input class="finish_btn" type="submit" value="수정완료">
                <input class="no_btn" type="button" onClick="location.href='main.html'" value="취소">
            </div>
        </div>
    </form>
    <script>
        function address_search() {
            new daum.Postcode({
                oncomplete: function (data) {
                    var addr = '';
                    var extraAddr = '';

                    if (data.userSelectedType === 'R') {
                        addr = data.roadAddress;
                    } else {
                        addr = data.jibunAddress;
                    }

                    if (data.userSelectedType === 'R') {
                        if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                            extraAddr += data.bname;
                        }
                        if (data.buildingName !== '' && data.apartment === 'Y') {
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        if (extraAddr !== '') {
                            extraAddr = ' (' + extraAddr + ')';
                        }
                    }

                    document.getElementById("address_").value = addr;
                    document.getElementById("detailAddress").focus();
                }
            }).open();
        }
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>

</html>
