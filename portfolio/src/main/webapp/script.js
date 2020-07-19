// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

function fadeIn(el) {
  el.style.opacity = 0;
  var tick = function () {
      el.style.opacity = +el.style.opacity + 0.01;
      if (+el.style.opacity < 1) {
          (window.requestAnimationFrame && requestAnimationFrame(tick)) || setTimeout(tick, 16)
      }
  };
  tick();
}

/**
 * Adds a random Image to the page.
 */
function randomizeImage() {
  // The images directory contains 7 images, so generate a random index between
  // 1 and 7.
  const imageIndex = Math.floor(Math.random() * 7) + 1;
  const imgUrl = 'assets/RandomImages/Image' + imageIndex + '.jpeg';

  const imgElement = document.createElement('img');
  imgElement.src = imgUrl;
  imgElement.id = 'random-image';

  const imageContainer = document.getElementById('random-image-container');
  // Remove the previous image.
  imageContainer.innerHTML = '';
  imageContainer.appendChild(imgElement);
  fadeIn(imgElement);
}

setInterval( randomizeImage, 2000 )

/** 
 * To fetch a random quote from the server and add it to our portfolio page
 * responsePromise -> TextPromise -> added to DOM
 */
function getRandomQuote() {
  fetch('/random-quote').then(response => response.json()).then((quote) => {
    
    var val = Math.floor(Math.random() * quote.quotes.length);
    console.log(quote.quotes[val]);
    document.getElementById('quote-container').innerText = quote.quotes[val];
  });
}
git 