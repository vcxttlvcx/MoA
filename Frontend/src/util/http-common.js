import axios from 'axios';
// axios 객체 생성
export default axios.create({
    
    baseURL: 'http://localhost:8000/moa/', // baseUrl
    headers: {
        'Content-type': 'application/json',
    },
});
