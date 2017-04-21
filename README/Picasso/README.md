# Picasso Tutorial


## Displaying images in ListView / GridView


* 在 `ArrayAdapter.getView()` 中调用 `Picasso.load(urls[position])` 下载 image 并显示在 ImageView 上，和之前演示的仅仅加载一张图片的调用方法完全一致：

    > Picasso call is exactly the same as in the previously used 'regular' loading of images.

* `Picasso.fit()` 方法导致 `android:scaleType="centerInside"` 无效。

* 必须设定 ListView 中的 ImageView 为固定高度，否则 ListView 不显示任何内容。

* Picasso 替开发者解决了 ImageView 重用，以及滑动过程中加载的问题：

     > we need to re-use layouts in ListViews to create a fast & smooth scrolling experience. One awesomeness of Picasso is that it automatically takes care of the request canceling, clearing of the ImageViews, and loading the correct image into the appropriate ImageView.

* Picasso 替开发者解决了缓存的问题：

    > When loading an image, Picasso uses three sources: memory, disk and network (ordered from fastest to slowest). Once again, there is nothing you'll have to do. Picasso hides all that complexity from you, while creating intelligently sized caches for you. 




## References

[Future Studio - Picasso Tutorials - Adapter Use (ListView, GridView, ...)](https://futurestud.io/tutorials/picasso-adapter-use-for-listview-gridview-etc)
