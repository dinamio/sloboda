package com.sloboda.site.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sloboda.site.entity.MainPhoto;
import com.sloboda.site.entity.Photo;
import com.sloboda.site.persistance.dao.PhotoDao;
import com.sloboda.site.persistance.dto.MainPhotoDto;
import com.sloboda.site.persistance.dto.PhotoDto;
import com.sloboda.site.translator.PhotoTranslator;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoTranslator photoTranslator;

	@Autowired
	private PhotoDao photoDao;

	@Override
	public List<MainPhoto> getPhotosForMain() {
		List<MainPhotoDto> photoDtos = photoDao.getAllPhotos();
		List<MainPhoto> result = new ArrayList<MainPhoto>();
		photoTranslator.fromDtoList(photoDtos, result);
		return result;
	}

	@Override
	public void insertPhoto(Photo photo) {
		PhotoDto dto = new PhotoDto();
		photoTranslator.toDto(photo, dto);
		photoDao.savePhoto(dto);
	}

  @Override
  public String insertPhotoAndReturnPath(UploadedFile file) {
    String newFileName = generateFileName();
    File des = new File("downloads/" + newFileName + file.getFileName().substring(file.getFileName().lastIndexOf('.')));
    des.getParentFile().mkdirs();
    try {
      des.createNewFile();
      copyFileUsingFileStreams(file.getInputstream(), des);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return des.getPath();
  }

  private String generateFileName() {
    SecureRandom random = new SecureRandom();
    return new BigInteger(130, random).toString(32);
  }

  private static void copyFileUsingFileStreams(InputStream source, File dest) throws IOException {
    OutputStream output = null;
    try {
      output = new FileOutputStream(dest);
      byte[] buf = new byte[1024];
      int bytesRead;
      while ((bytesRead = source.read(buf)) > 0) {
        output.write(buf, 0, bytesRead);
      }
    } finally {
      output.close();
    }
  }

}
