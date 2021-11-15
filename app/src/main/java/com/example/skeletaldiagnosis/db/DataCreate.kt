package com.example.skeletaldiagnosis.db

import android.content.Context
import java.time.LocalDate

class DataCreate {

    fun ItemDataCreate(context: Context){

        val database = ItemDatabase.getInstance(context)
        val itemDao = database.itemDao()

        if (itemDao.getAll().isEmpty()) {

            // 新規Itemの作成
            val trenchCoat = Item(0,
                "トレンチコート",
                "trench_coat",
                true,
                false,
                false,
                true,
                false,
                true,
                0,
                "コートの素材のハリが肌質とマッチし、着膨れしない。探偵が好んで着る服。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(trenchCoat)

            val jacket = Item(0,
                "ジャケット",
                "jacket",
                true,
                false,
                false,
                false,
                true,
                false,
                0,
                "どんなシーンでも大人らしさを演出できる万能アイテム。着るだけで知的に見えるからふしぎ。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(jacket)

            val duffleCoat = Item(0,
                "ダッフルコート",
                "duffle_coat",
                false,
                true,
                false,
                false,
                true,
                false,
                0,
                "柔らかい雰囲気を醸し出せる冬アウターの本命枠。色合いによって印象はガラリと変わる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(duffleCoat)

            val foodBlouson = Item(0,
                "フードブルゾン",
                "food_blouson",
                false,
                false,
                true,
                false,
                true,
                false,
                0,
                "フード付きでかわいさを演出し、ブルゾン本来の無骨さを中和。\nフードなブルゾン。気分もるんるん。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(foodBlouson)

            val shortBlouson = Item(0,
                "ショートブルゾン",
                "short_blouson",
                false,
                false,
                true,
                false,
                false,
                false,
                0,
                "無骨ながらもオシャレ度UP間違いなし。その魅力は35億。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(shortBlouson)

            val vNeckTopps = Item(0,
                "Vネックトップス",
                "v_neck_tops",
                true,
                false,
                false,
                true,
                false,
                true,
                1,
                "首回りに余裕があり、厚みのあるボディをスッキリ見せる。\n白いトップス。それはそれは白いトップス。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(vNeckTopps)

            val highGaugeKnit = Item(0,
                "ハイゲージニット",
                "high_gauge_knit",
                true,
                false,
                false,
                false,
                false,
                true,
                1,
                "編み目が細かく、スッキリした印象がある。スーツスタイルでもカジュアルスタイルでも活躍間違いなし。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(highGaugeKnit)

            val lowGaugeKnit = Item(0,
                "ローゲージニット",
                "low_gauge_knit",
                false,
                true,
                false,
                false,
                true,
                false,
                1,
                "編み目が粗く、ザックリした印象がある。ボリュームがあり、凹凸や模様で個性をだすことができる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(lowGaugeKnit)

            val crewNeckKnit = Item(0,
                "クルーネックニット",
                "crew_neck_knit",
                false,
                false,
                true,
                false,
                false,
                false,
                1,
                "丸襟のベーシックなニット。ニットといえば大体コレ。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(crewNeckKnit)

            val turtleNeckKnit = Item(0,
                "タートルネックニット",
                "turtle_neck_knit",
                false,
                true,
                true,
                false,
                false,
                false,
                1,
                "折り返すほど襟が長いニット。実業家は大体タートルネックにジャケット愛用。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(turtleNeckKnit)

            val shoulderDropTops = Item(0,
                "肩落ちトップス",
                "shoulder_drop_tops",
                false,
                false,
                false,
                true,
                false,
                false,
                1,
                "普通のトップスよりも袖付け線が低めの位置にあるトップス。ドロップショルダーとも呼ばれる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(shoulderDropTops)

            val parka = Item(0,
                "パーカー",
                "parka",
                false,
                true,
                false,
                false,
                false,
                false,
                1,
                "ちょっと外出したい時や本気コーデにも使える汎用アイテム。パーカーの中にも意外と種類がある。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(parka)

            val slacks = Item(0,
                "スラックス",
                "slacks",
                true,
                false,
                false,
                false,
                true,
                false,
                2,
                "センタープレスパンツ。キレイ目なコーディネイトと相性抜群。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(slacks)

            val skinnyPants = Item(0,
                "スキニーパンツ",
                "skinny_pants",
                false,
                true,
                false,
                false,
                false,
                false,
                2,
                "脚にぴったりフィットするシルエットのパンツ。脚のラインがモロにでるため、筋肉質の脚は太って見える。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(skinnyPants)

            val widePants = Item(0,
                "ワイドパンツ",
                "wide_pants",
                false,
                false,
                false,
                false,
                true,
                false,
                2,
                "全体的に幅の広いパンツ。図らずともカジュアルな雰囲気になる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(widePants)

            val croppedPants = Item(0,
                "クロップドパンツ",
                "cropped_pants",
                false,
                false,
                false,
                false,
                false,
                true,
                2,
                "裾丈を通常よりも短くカットしたもの。大抵は6~7分丈。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(croppedPants)

            val tuckPants = Item(0,
                "タックパンツ",
                "tuck_pants",
                false,
                false,
                true,
                false,
                false,
                false,
                2,
                "縫いひだ、つまみが入ったパンツ。タックのおかげでゆとりが生まれ、スタイルアップ効果の期待ができる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(tuckPants)

            val loosePants = Item(0,
                "ルーズパンツ",
                "loose_pants",
                false,
                false,
                false,
                true,
                false,
                false,
                2,
                "太めのゆったりしたシルエットのパンツ。簡単にカジュアルな雰囲気をだすことができる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(loosePants)

            val halfPants = Item(0,
                "ハーフパンツ",
                "half_pants",
                true,
                false,
                false,
                false,
                false,
                false,
                2,
                "ヒザ丈の短いパンツ。その短さゆえ冬季に履くと異様な目で見られるが、小学生は年中ハーフパンツを愛用している。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(halfPants)

            val noTuckPants = Item(0,
                "ノータックパンツ",
                "no_tuck_pants",
                false,
                false,
                true,
                false,
                false,
                false,
                2,
                "その名の通りタックがないパンツ。折ひだがないため、裾幅が細くなり、スッキリした印象を与えることができる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(noTuckPants)

            val tie = Item(0,
                "ネクタイ",
                "tie",
                true,
                false,
                true,
                false,
                false,
                false,
                2,
                "デキる男の必需品。社畜であることを示すための首輪。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(tie)

            val stripedPattern = Item(0,
                "ストライプ",
                "striped_pattern",
                true,
                false,
                true,
                false,
                true,
                false,
                5,
                "縦縞の視覚効果により、実際の身長より高く見える効果を与えることができる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(stripedPattern)

            val borderPattern = Item(0,
                "ボーダー",
                "border_pattern",
                true,
                false,
                true,
                false,
                true,
                false,
                5,
                "横縞の視覚効果により、人によっては実際の横幅より太って見えてしまう。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(borderPattern)


            val windowPenPattern = Item(0,
                "ウィンドウペン",
                "window_pen_pattern",
                true,
                false,
                false,
                false,
                false,
                false,
                5,
                "単色の縦横の細い線で四角形を形づくる格子柄。仕事用のスーツでできる数少ない遊び心。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(windowPenPattern)

            val largeDotPattern = Item(0,
                "大柄ドット",
                "large_dot_pattern",
                true,
                false,
                false,
                false,
                false,
                false,
                5,
                "粒度の大きい水玉模様。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(largeDotPattern)

            val dotPattern = Item(0,
                "ドット",
                "dot_pattern",
                false,
                false,
                true,
                false,
                false,
                false,
                5,
                "いわゆる水玉模様。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(dotPattern)

            val largeCheckPattern = Item(0,
                "大柄チェック",
                "large_check_pattern",
                false,
                false,
                false,
                false,
                true,
                false,
                5,
                "大柄なチェック。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(largeCheckPattern)

            val checkPattern = Item(0,
                "チェック",
                "check_pattern",
                false,
                false,
                true,
                false,
                true,
                false,
                5,
                "通常サイズのチェック。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(checkPattern)

            val glenCheckPattern = Item(0,
                "グレンチェック",
                "glen_check_pattern",
                true,
                false,
                false,
                false,
                false,
                false,
                5,
                "数パターンの細かな格子の四角形を配置し、大きな格子柄に見せている。グレーや黒、ベージュなどのベーシックカラーを中心に構成されることが多い。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(glenCheckPattern)

            val ginghamCheckPattern = Item(0,
                "ギンガムチェック",
                "gingham_check_pattern",
                false,
                false,
                true,
                false,
                true,
                false,
                5,
                "白と他の色の2色のみを使用した、シンプルな格子柄。春夏のファッションに多く用いられ、爽やかな印象を与えられる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(ginghamCheckPattern)

            val paisleyPattern = Item(0,
                "ペイズリー",
                "paisley_pattern",
                false,
                false,
                false,
                false,
                true,
                false,
                5,
                "イギリスのペイズリー市発祥のデザイン。顕微鏡で拡大したミトコンドリアやゾウリムシのような形。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(paisleyPattern)

            val argylePattern = Item(0,
                "アーガイル",
                "argyle_pattern",
                true,
                false,
                false,
                false,
                true,
                false,
                5,
                "複数の色の菱形で構成されている。ニット素材でしかこの柄を見ない気がする。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(argylePattern)

            val squarePattern = Item(0,
                "スクエア",
                "square_pattern",
                true,
                false,
                false,
                false,
                false,
                false,
                5,
                "小さな四角形が集合して大きな四角形に見せていたり、小さな四角形が無数に集合していたりと幅広い柄。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(squarePattern)

            val woolMaterial = Item(0,
                "ウール",
                "wool_material",
                true,
                false,
                false,
                false,
                false,
                false,
                6,
                "羊毛。冬アイテムにはかかせない素材だが、毛玉ができたりするのでメンテナンスは必要。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(woolMaterial)

            val smoothLeatherMaterial = Item(0,
                "スムースレザー",
                "smooth_leather_material",
                true,
                false,
                false,
                true,
                false,
                true,
                6,
                "表面がなめらかな皮。皮製品が似合うようになってからが一人前。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(smoothLeatherMaterial)

            val highGaugeKnitMaterial = Item(0,
                "ハイゲージニット",
                "high_gauge_knit_material",
                true,
                false,
                true,
                false,
                false,
                true,
                6,
                "編み目が細かく、スマートな印象を与えることができる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(highGaugeKnitMaterial)

            val lowGaugeKnitMaterial = Item(0,
                "ローゲージニット素材",
                "low_gauge_knit_material",
                false,
                true,
                false,
                true,
                true,
                false,
                6,
                "編み目が粗く、暖かくて優しい印象を与えることができる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(lowGaugeKnitMaterial)

            val broadMaterial = Item(0,
                "ブロード",
                "broad_material",
                true,
                false,
                false,
                false,
                false,
                true,
                6,
                "Yシャツなどに使用される通気性のいい素材。その通気性ゆえに、ブロード素材の服だけでは透けてしまう。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(broadMaterial)

            val coarseCottonMaterial = Item(0,
                "粗いコットン",
                "coarse_cotton_material",
                false,
                true,
                false,
                true,
                false,
                false,
                6,
                "粗い綿素材。ごわごわした印象を与えるため、やせ型や骨が目立つタイプが着用するとバランスがいい。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(coarseCottonMaterial)

            val particularCottonMaterial = Item(0,
                "きめ細かなコットン",
                "particular_cotton_material",
                true,
                false,
                false,
                false,
                false,
                false,
                6,
                "きめ細かな綿素材。機能的で肌ざわりもよく万能。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(particularCottonMaterial)

            val sweatMaterial = Item(0,
                "スウェット",
                "sweat_material",
                false,
                true,
                false,
                false,
                false,
                false,
                6,
                "綿を平編みにしたニット生地。伸縮性、吸汗性、防寒性に優れている。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(sweatMaterial)

            val stretchMaterial = Item(0,
                "ストレッチ",
                "stretch_material",
                false,
                true,
                true,
                false,
                false,
                true,
                6,
                "黄色い全身タイツのおじさんが好きそうな素材。着用するだけでストレッチパワーが上昇。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(stretchMaterial)

            val mohairMaterial = Item(0,
                "モヘア",
                "mohair_material",
                false,
                false,
                true,
                false,
                false,
                false,
                6,
                "アンゴラ山羊から採取した毛。絹のようなつややかな光沢と柔らかな手触りで、毛足が長い。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(mohairMaterial)

            val suedeMaterial = Item(0,
                "スエード",
                "suede_material",
                false,
                false,
                true,
                false,
                true,
                false,
                6,
                "表面が起毛している革。ポリエステルやアクリルに特殊なポリウレタンを混ぜたフェイクスエードなどもある。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(suedeMaterial)

            val corduroyMaterial = Item(0,
                "コーデュロイ",
                "corduroy_material",
                false,
                false,
                false,
                true,
                true,
                false,
                6,
                "表面にうねのような凸凹があるのが最大の特徴。保温性が高く、冬服に使われる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(corduroyMaterial)

            val linenMaterial = Item(0,
                "麻",
                "linen_material",
                false,
                false,
                false,
                false,
                true,
                false,
                6,
                "丈夫で長持ち、しかも汚れにくい。服で麻と表記されているものはリネンかラミーが原料。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(linenMaterial)

            val denimMaterial = Item(0,
                "デニム",
                "denim_material",
                true,
                false,
                false,
                false,
                true,
                false,
                6,
                "素材が綿の厚地織布。よくデニムとジーンズが混同されるが、デニムは生地の種類、ジーンズはデニム素材のパンツ。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(denimMaterial)

            val seersuckerMaterial = Item(0,
                "シアサッカー",
                "seersucker_material",
                false,
                false,
                true,
                false,
                false,
                false,
                6,
                "薄く、しわがある綿の素材。通気性がよく、パジャマなどに使われる。間違ってアイロンがけしないよう注意。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(seersuckerMaterial)

            val tuIllMaterial = Item(0,
                "ツイル",
                "tu_ill_material",
                false,
                false,
                true,
                false,
                false,
                false,
                6,
                "織り方の一つである綾織の別名。素材によって○○ツイルと名前が変わる。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(tuIllMaterial)

            val pilePlaceMaterial = Item(0,
                "パイル地",
                "pile_place_material",
                false,
                false,
                true,
                false,
                true,
                false,
                6,
                "織り方の一種。主にタオルなどに使われている。",
                "hvvvy",
                LocalDate.now().toString(),
                "hvvvy",
                LocalDate.now().toString())
            // Itemテーブルにレコードを追加
            itemDao.insert(pilePlaceMaterial)

        }
        //新しくデータを追加するには、一度下記のdeleteAll()メソッドのコメントを外してアプリを実行し、再度コメントして実行することにより新しくテーブルを作成する
        //開発段階でのみ使用。リリース時には完全なItemテーブルを作成している予定なので、このメソッドは最後に削除する
        //itemDao.deleteAll()
    }
}

