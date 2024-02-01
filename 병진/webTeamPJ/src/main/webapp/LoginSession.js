// LoginSession.js

// 추후 네비이션바의 사용을 위해 남겨두는 더미데이터
// 비회원 유저를 위한 도구로 사용될 예정

/*
var navElement = document.getElementById('navbarNav');

function showLoginSuccessAlert() {
    alert('로그인 성공!');
}

window.onload = function () {
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('success')) {
        showLoginSuccessAlert();

        // 'success' 파라미터가 있으면 닉네임을 가져와서 변수에 저장
        const id = urlParams.get('id');
        const pw = urlParams.get('pw');
        const nickname = urlParams.get('nickname');
        const name = urlParams.get('name');
        const address = urlParams.get('address');
        const tel = urlParams.get('tel');
        const birth = urlParams.get('birth');
        console.log('Login ID:', id);
        console.log('Login PW:', pw);
        console.log('Login NickName:', nickname);
        console.log('Login name:', name);
        console.log('Login address:', address);
        console.log('Login tel:', tel);
        console.log('Login birth:', birth);
        
        // 수정: 닉네임이 유효하면 로그인 상태로 처리
        if (id && id.length > 0) {
            console.log('로그인 상태. 로그아웃 링크 생성');
            // 로그인 상태일 때 로그아웃 링크 생성
            var logoutLink = document.createElement('li');
            logoutLink.className = 'nav-item';
            logoutLink.innerHTML = '<a class="nav-link" href="logout.do">로그아웃</a>';
            navElement.appendChild(logoutLink);
        }
    } else {
        console.log('로그인 상태가 아님. 로그인 링크 생성');
        // 로그인 상태가 아닐 때 로그인 링크 생성
        var loginLink = document.createElement('li');
        loginLink.className = 'nav-item';
        loginLink.innerHTML = '<a class="nav-link" href="login.html">로그인</a>';
        navElement.appendChild(loginLink);
    }
};*/
