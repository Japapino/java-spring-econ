const xhr = new XHMLHttpRequest(); 
xhr.onreadystatechange = function () {
	if (xhe.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText) 
		const productsContainer = document.querySelector('#products-container')

		for (let product in res) {
			const productContainer = document.createElement('div')
			const productLink = document.createElement('a')
			productLink.setAttribute('href', '/catalog/product.html')
			productContainer.innerText = product.name
			productLink.innerText = product.name
			productContainer.appendChild(productLink)
			productsContainer.appendChild(productContainer)
		}
	}
}

xhr.open('GET', '/products',true)
xhr.send()