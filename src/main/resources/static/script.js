document.addEventListener('DOMContentLoaded', () => {
    const shortenBtn = document.getElementById('shortenBtn');
    const urlInput = document.getElementById('urlInput');
    const resultDiv = document.getElementById('result');
    const errorDiv = document.getElementById('error');
    const shortUrlLink = document.getElementById('shortUrlLink');
    const copyBtn = document.getElementById('copyBtn');
    const feedbackDiv = document.getElementById('feedback');

    shortenBtn.addEventListener('click', async () => {
        const originalUrl = urlInput.value.trim();

        resultDiv.classList.add('hidden');
        errorDiv.classList.add('hidden');
        feedbackDiv.textContent = '';

        if (!originalUrl) {
            showError('Por favor, insira uma URL.');
            return;
        }

        try {
            const response = await fetch('/shorten', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ url: originalUrl }),
            });

            const data = await response.json();

            if (!response.ok) {
                throw new Error(data.error || 'Ocorreu um erro.');
            }

            showResult(data.shortUrl);

        } catch (err) {
            showError(err.message);
        }
    });

    copyBtn.addEventListener('click', () => {
        navigator.clipboard.writeText(shortUrlLink.href)
            .then(() => {
                feedbackDiv.textContent = 'Copiado!';
                setTimeout(() => feedbackDiv.textContent = '', 2000);
            })
            .catch(err => {
                feedbackDiv.textContent = 'Falha ao copiar.';
            });
    });

    function showResult(url) {
        shortUrlLink.href = url;
        shortUrlLink.textContent = url;
        resultDiv.classList.remove('hidden');
    }

    
});