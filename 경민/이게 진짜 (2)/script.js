// 게시글 목록 초기화
var posts = initPosts();

// 게시글 작성 버튼 클릭 시
$('#postSubmit').click(function () {
    var postTitle = $('#postTitle').val();
    var postContent = $('#postContent').val();
    var postImage = $('#postImage').val();
    var currentBoard = window.location.pathname.split('/').pop().split('.')[0];
    var post = {
        title: postTitle,
        content: postContent,
        image: postImage,
        comments: [],
        board: currentBoard // 현재 페이지의 게시판 식별자로 설정
    };
    posts.push(post);
    localStorage.setItem('posts', JSON.stringify(posts));
    // 글 작성이 완료되면 board1.html로 이동
    window.location.href = 'board1.html';
});

// 게시글 목록 렌더링
function renderPosts() {
    var postList = $('#postList');
    postList.empty();
    for (var i = posts.length - 1; i >= 0; i--) {
        var post = posts[i];
        var postItem = $('<div class="card mb-3"><div class="card-body"><h5 class="card-title post-link" data-post-id="' + i + '">' + post.title + '</h5></div></div>');
        postList.append(postItem);
    }
    $('.post-link').click(function () {
        var postId = $(this).data('post-id');
        window.location.href = 'detail.html?id=' + postId;
    });
}

// 초기화 이후에 한 번만 renderPosts() 함수를 호출
renderPosts();

// 게시글 목록 초기화
function initPosts() {
    var savedPosts = localStorage.getItem('posts');
    if (savedPosts) {
        return JSON.parse(savedPosts);
    } else {
        return [];
    }
}

// detail 페이지 초기화
$(document).ready(function () {
    initDetailPage();

    // 게시글 상세 페이지 초기화 함수
    function initDetailPage() {
        var postId = getParameterByName('id');
        if (postId !== null) {
            var post = posts[postId];
            if (post) {
                $('#postTitle').text(post.title);
                $('#postContent').text(post.content);

                $('.delete-btn').click(function () {
                    deletePost(postId);
                });

                $('.edit-btn').attr('href', 'edit.html?id=' + postId);
            }
        }
    }

    // URL에서 파라미터 값을 가져오는 함수
    function getParameterByName(name) {
        var url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }

    // 게시물 삭제 함수
    function deletePost(postId) {
        if (confirm("게시물을 삭제하시겠습니까?")) {
            posts.splice(postId, 1);
            localStorage.setItem('posts', JSON.stringify(posts));
            window.location.href = 'board1.html';
        }
    }
});

// edit 페이지 초기화
$(document).ready(function () {
    initEditPage();

    // edit 페이지 초기화 함수
    function initEditPage() {
        var postId = getParameterByName('id');
        if (postId !== null) {
            var post = posts[postId];
            if (post) {
                $('#postTitle').val(post.title);
                $('#postContent').val(post.content);

                $('#postUpdate').click(function () {
                    updatePost(postId);
                });
            }
        }
    }

    // 게시물 업데이트 함수
    function updatePost(postId) {
        var postTitle = $('#postTitle').val();
        var postContent = $('#postContent').val();
        var post = {
            title: postTitle,
            content: postContent,
            comments: [],
            board: 'board1' // 수정 시 게시판 정보를 변경하지 않음
        };
        posts[postId] = post;
        localStorage.setItem('posts', JSON.stringify(posts));
        window.location.href = 'detail.html?id=' + postId;
    }

    // URL에서 파라미터 값을 가져오는 함수
    function getParameterByName(name) {
        var url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }
});
