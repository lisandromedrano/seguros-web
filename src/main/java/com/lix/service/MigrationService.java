package com.lix.service;

import java.io.File;

import com.lix.dto.DefaultResponse;

public interface MigrationService {
	DefaultResponse importZipCSV(File f);

	DefaultResponse importZipCSV(String fileName);
}
