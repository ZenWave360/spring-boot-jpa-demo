function fn() {
    karate.configure('headers', { accept: 'application/json' });

    return {
        baseUrl: 'http://localhost:8080/api',
        auth: {
            username: 'user',
            password: 'password'
        }
        
    };
}