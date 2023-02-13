const btns = document.getElementsByClassName('decision');
const recordPanel = document.getElementById('record-panel');
const computer = document.getElementById('computer');
const message = document.getElementById('message');
const logout = document.getElementById('logout');

const loadRecord = () => {
    const recordStr = localStorage.getItem(userName);

    if (recordStr == null || recordStr == '') {
        return {
            win: 0,
            draw: 0,
            lose: 0
        }
    } else {
        // JSON 형태의 문자열 덩어리를 자바스크립트 오브젝트로 변환
        return JSON.parse(localStorage.getItem(userName));
    }
}

const record = loadRecord();

const printRecord = () => {
    winRate = record.win / (record.win + record.draw + record.lose);
    
    winRate = Math.round(winRate * 100);

    recordPanel.innerText = `win : ${record.win} draw :  ${record.draw} lose : ${record.lose}`
    + `(${winRate}%)`;
}

const comImage = [
    contextPath + '/resources/image/scissors.png',
    contextPath + '/resources/image/rock.png',
    contextPath + '/resources/image/paper.png'
]

// 0: 가위, 1: 바위, 2: 보
const getResult = (num) => {
    const com = parseInt(Math.random() * 3);
    
    // change computer image
    computer.style.backgroundImage = 
        'url('+ comImage[com] +')';

    if (com == num) {
        return 'draw';
    } else if (com == (num + 1) % 3) {
        return 'lose';
    } else {
        return 'win';
    }
    // com == num + 1 % 3; // 사람이 짐
    // num == com + 1 % 3; // 사람이 이김
    // num == com // 비김
}

const clickAction = (e) => {
    console.log('I clicked: ', e.target);

    const btn = e.target;
                                    // html의 data-num을 불러옴
    console.log('this element got: ', btn.dataset.num);

    const result = getResult(btn.dataset.num);

    console.log('Game Result: ', result);

    message.innerText = result.toUpperCase() + '!';

    record[result] += 1;

    console.log(record);
    
    printRecord();

    // 자바스크립트 오브젝트를 문자열로 변환하여 저장하기 (JSON)
    const record_json = JSON.stringify(record);
    
    localStorage.setItem(userName, record_json)
}

logout.addEventListener('click', () => {
    location.href = contextPath + '/mygame/logout';
});

for (i = 0; i < btns.length; ++i) {
    console.log(btns[i]);

    btns[i].addEventListener('click', clickAction);
}

printRecord();
